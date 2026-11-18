param(
    [Parameter(Mandatory = $true, Position = 0)]
    [ValidateRange(1, 8)]
    [int]$Exercise
)

$folderName = 'exercise-{0:D2}' -f $Exercise
$sourceDir = Join-Path $PSScriptRoot $folderName
$buildDir = Join-Path $PSScriptRoot "build\$folderName"
$mainClass = "Exercise$Exercise"

if (-not (Get-Command javac -ErrorAction SilentlyContinue) -or -not (Get-Command java -ErrorAction SilentlyContinue)) {
    Write-Error 'Java JDK is missing or java/javac are not on PATH.'
    exit 1
}

New-Item -ItemType Directory -Path $buildDir -Force | Out-Null
Push-Location $sourceDir
try {
    $sources = @(Get-ChildItem -Filter '*.java' | ForEach-Object { $_.Name })
    & javac -encoding UTF-8 -d $buildDir @sources
    if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }

    & java -cp $buildDir $mainClass
    if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }
}
finally {
    Pop-Location
}
