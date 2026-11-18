param(
    [Parameter(Mandatory = $true, Position = 0)]
    [ValidateRange(1, 8)]
    [int]$Exercise
)

$sourceDir = Join-Path $PSScriptRoot 'src/main/java'
$buildDir = Join-Path $PSScriptRoot 'build/classes'
$packageSuffix = 'exercise{0:D2}' -f $Exercise
$mainClass = "se.lexicon.exceptions.$packageSuffix.Exercise$Exercise"

if (-not (Get-Command javac -ErrorAction SilentlyContinue) -or -not (Get-Command java -ErrorAction SilentlyContinue)) {
    Write-Error 'Java JDK is missing or java/javac are not on PATH.'
    exit 1
}

New-Item -ItemType Directory -Path $buildDir -Force | Out-Null
Push-Location $PSScriptRoot
try {
    $sources = @(Get-ChildItem -Path $sourceDir -Filter '*.java' -Recurse -File | ForEach-Object { $_.FullName })
    if ($sources.Count -eq 0) {
        Write-Error 'No Java source files found.'
        exit 1
    }

    & javac -encoding UTF-8 -d $buildDir @sources
    if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }

    & java -cp $buildDir $mainClass
    if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }
}
finally {
    Pop-Location
}
