curl -X POST "http://localhost:8080/subscription/create" \
     -H "Content-Type: application/json" \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjb25zIiwicm9sZSI6W3siYXV0aG9yaXR5IjoiY29uc3VtZXIifV0sImV4cCI6MTY4NTQ5NzM4MiwiaWF0IjoxNjg1NDYxMzgyfQ.4pFE1PkYo0CW66Bxo306oQcsK9dxwxDCjLnm0WrDeGw" \
     -d '{
           "consumer_username": "cons",
           "stoplight_id": 2,
           "pedestrianButton_id": null,
           "topic_name": "traffic_lights"
         }'