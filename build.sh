#!/bin/bash

set -o errexit
set -o nounset
set -o pipefail
set -o xtrace

readonly IMAGE_NAME='amazoncorretto:8u202'
readonly JAVA_HOME='/usr'

readonly SCRIPT_DIR="$(cd "$(dirname "$0")"; pwd)"
# Testcontainers で利用する docker-entrypoint-initdb.d のパスが
# コンテナ内からもホストからも同じであるようにワーキングディレクトリを設定
readonly CONTAINER_WORKING_DIR="${SCRIPT_DIR}"

docker run \
  --rm \
  -v "${SCRIPT_DIR}:${CONTAINER_WORKING_DIR}" \
  -v "${HOME}/.m2:/root/.m2" \
  -v '/var/run/docker.sock:/var/run/docker.sock' \
  -w "${CONTAINER_WORKING_DIR}" \
  -e "JAVA_HOME=${JAVA_HOME}" \
  "${IMAGE_NAME}" \
  ./mvnw clean package
