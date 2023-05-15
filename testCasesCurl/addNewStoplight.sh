curl -X POST "http://localhost:8080/stoplight/create" \
     -H "Content-Type: application/json" \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiYWxhbGxHaXJvIiwicm9sZSI6W3siYXV0aG9yaXR5IjoicHJvZHVjZXIifV0sImV4cCI6MTY4NDE4NzE1NSwiaWF0IjoxNjg0MTUxMTU1fQ.-0kPutAfiUsvmYIOrAqS0KMqHlYgKUxBK-jc_yNOOo4" \
     -d '{
           "longitude": 12.4924,
           "latitude": 41.8902,
           "redColor": true,
           "yellowColor": true,
           "greenColor": true
         }'