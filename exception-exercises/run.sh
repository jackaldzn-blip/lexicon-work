#!/usr/bin/env bash
set -euo pipefail

if [[ $# -ne 1 || ! "$1" =~ ^[1-8]$ ]]; then
  echo "Usage: ./run.sh <exercise-number: 1-8>" >&2
  exit 1
fi

base_dir="$(cd "$(dirname "$0")" && pwd)"
class_dir="$base_dir/build/classes"
mkdir -p "$class_dir"
cd "$base_dir"
mapfile -d '' sources < <(find src/main/java -type f -name '*.java' -print0)
javac -encoding UTF-8 -d "$class_dir" "${sources[@]}"
package_suffix="$(printf 'exercise%02d' "$1")"
java -cp "$class_dir" "se.lexicon.exceptions.${package_suffix}.Exercise$1"
