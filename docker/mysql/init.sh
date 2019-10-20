#!/usr/bin/env bash
mysql -u root -p${MYSQL_ROOT_PASSWORD}<<EOF
source /tmp/table.sql;
EOF

echo "=========================="