#!/usr/bin/env bash
mvn clean install -Dtest=TestRunner -Dcucumber.filter.tags="@smoke" -Dbrowser.option.headless=false && open target/index.html
