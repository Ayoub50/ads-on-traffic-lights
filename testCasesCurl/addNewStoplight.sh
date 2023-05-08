curl -X POST "http://localhost:8080/api/stoplight/create" \
     -H "Content-Type: application/json" \
     -d '{
           "longitude": 12.4924,
           "latitude": 41.8902,
           "redColor": true,
           "yellowColor": true,
           "greenColor": true,
           "producer": 1
         }'
