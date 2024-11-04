#!/usr/bin/env bash
mvn clean install -Dtest=TestRunner -Dcucumber.filter.tags="@smoke" && open target/index.html
