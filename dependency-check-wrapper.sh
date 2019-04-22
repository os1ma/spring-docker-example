#!/bin/bash
#
# See: https://hub.docker.com/r/owasp/dependency-check

set -o errexit
set -o nounset
set -o pipefail
set -o xtrace

readonly IMAGE_TAG='4.0.2'

readonly SCRIPT_DIR="$(cd "$(dirname "$0")"; pwd)"
readonly PROJECT_HOME="${SCRIPT_DIR}"
readonly PROJECT_NAME="$(basename ${PROJECT_HOME})"

readonly OWASPDC_DIRECTORY="${PROJECT_HOME}/OWASP-Dependency-Check"
readonly DATA_DIRECTORY="${OWASPDC_DIRECTORY}/data"
readonly REPORT_DIRECTORY="${OWASPDC_DIRECTORY}/reports"

if [ ! -d "${DATA_DIRECTORY}" ]; then
  echo "Initially creating persistent directories"
  mkdir -p "${DATA_DIRECTORY}"
  chmod -R 777 "${DATA_DIRECTORY}"

  mkdir -p "${REPORT_DIRECTORY}"
  chmod -R 777 "${REPORT_DIRECTORY}"
fi

docker run \
  --rm \
  --volume "${PROJECT_HOME}:/src" \
  --volume "${DATA_DIRECTORY}:/usr/share/dependency-check/data" \
  --volume "${REPORT_DIRECTORY}:/report" \
  "owasp/dependency-check:${IMAGE_TAG}" \
    --scan '/src' \
    --format 'ALL' \
    --project "${PROJECT_NAME}" \
    --out /report
