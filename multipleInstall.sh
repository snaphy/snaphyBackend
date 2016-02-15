#!/bin/bash
#
# Run npm install for all Node.js packages under a given directory.
#
# Usage: $0 <directory>
#

set -o nounset
set -o errexit

# Check the input.
if [ "$#" -lt 1 ]; then
  echo "Usage: $0 <directory>"
  exit 1
fi

# The absolute path of the directory containing this script.
SCRIPT_DIR="$( cd "$( dirname "$0" )" && pwd)"

# The directory holding the Node.js packages of interest.
DIR="$1"

# Number of processors. We want to run NPM installations concurrently since
# they can be time-consuming.
NPROC=`nproc`

# First clean out any existing installed modules. We don't want find picking up
# all of their package.json files.
#
# The use of -print0 in find and -0 for xargs is good practice as it prevents
# paths containing meaningful characters such as spaces and commas from
# messing things up.
find "${DIR}" -name "node_modules" -print0 |
  xargs -0 --max-procs=${NPROC} rm -Rf

# Then run npm install in every directory with a package.json file. This probably
# requires a little explanation, so an annotated version precedes the actual
# command.
#
# # Obtain a set of absolute paths to package.json files. See the above note on
# # use of -print0.
# find "${DIR}" -name "package.json" -print0 |
#   # Now strip the /package.json part of each path to leave just the directory.
#   # Note that this is all one line so far as sed is concerned, since -print0
#   # uses null separators, so we have to specify the global flag.
#   sed s,/package.json,,g |
#   # Next feed the list of absolute paths into xargs and run a command for
#   # each of them.
#   xargs
#     # See the above note on the use of -0.
#     -0
#     # Run these processes concurrently, with a limit equal to the number of
#     # cores on this machine.
#     --max-procs=${NPROC}
#     # Replace % in the following command with the path passed to xargs.
#     -I %
#       # Run the quoted bash command.
#       bash -c "${SCRIPT_DIR}/npm-install-called-by-xargs.sh %"
#
find "${DIR}" -name "package.json" -print0 |
  sed s,/package.json,,g |
  xargs
    -0
    --max-procs=${NPROC}
    -I %
    bash -c "${SCRIPT_DIR}/npm-install-called-by-xargs.sh %"
