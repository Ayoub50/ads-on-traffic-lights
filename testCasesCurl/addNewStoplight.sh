curl -X POST "http://localhost:8080/stoplight/create" \
     -H "Content-Type: application/json" \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiYWxhbGxHaXJvIiwicm9sZSI6W3siYXV0aG9yaXR5IjoicHJvZHVjZXIifV0sImV4cCI6MTY4MzkzNTI4NCwiaWF0IjoxNjgzODk5Mjg0fQ.YsI3DslsjxsaiHHnQK0LogXCKBDSlMj-cl6V9iQsovI" \
     -d '{
           "longitude": 12.4924,
           "latitude": 41.8902,
           "redColor": true,
           "yellowColor": true,
           "greenColor": true
         }'