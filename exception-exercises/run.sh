#!/usr/bin/env bash
set -euo pipefail

if [[ $# -ne 1 || ! "$1" =~ ^[1-8]$ ]]; then
  echo "Usage: ./run.sh <exercise-number: 1-8>" >&2
  exit 1
fi

base_dir="$(cd "$(dirname "$0")" && pwd)"
folder="$(printf 'exercise-%02d' "$1")"
mkdir -p "$base_dir/build/$folder"
cd "$base_dir/$folder"
javac -encoding UTF-8 -d "$base_dir/build/$folder" ./*.java
java -cp "$base_dir/build/$folder" "Exercise$1"
