# Run from any PowerShell working directory: .\run.ps1
# This compiles the complete project, not only App.java.
$ErrorActionPreference = 'Stop'

$srcPath = Join-Path $PSScriptRoot 'src\main\java'
$testPath = Join-Path $PSScriptRoot 'src\test\java'
$outPath = Join-Path $PSScriptRoot 'out'
New-Item -ItemType Directory -Path $outPath -Force | Out-Null

$sources = @(
    Get-ChildItem -Path $srcPath -Filter '*.java' -File | ForEach-Object { $_.FullName }
    Get-ChildItem -Path $testPath -Filter '*.java' -File | ForEach-Object { $_.FullName }
)

& javac -encoding UTF-8 -d $outPath @sources
if ($LASTEXITCODE -ne 0) { throw "Java compilation failed (exit $LASTEXITCODE)." }

Write-Host "`n--- Run Bank app ---"
& java -cp $outPath App
if ($LASTEXITCODE -ne 0) { throw "App execution failed (exit $LASTEXITCODE)." }

Write-Host "`n--- Run Bank assertions ---"
& java -ea -cp $outPath BankExerciseTest
if ($LASTEXITCODE -ne 0) { throw "Bank checks failed (exit $LASTEXITCODE)." }
