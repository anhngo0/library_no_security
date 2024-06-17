# library_no_security
chạy bằng docker: 
          - mở command line của folder chứa project đã clone về
          - nhập "docker compose up --build" để build image và run container 
          - ctrl + C dể dừng chạy
          - chạy lại : + dùng docker desktop 
                       + hoặc gó 'docker ps -a' -> tìm tên container | chạy lệnh "docker start <tên container>"
Mở browser --> gõ http://localhost:8081/swagger-ui/index.html để đọc api docs
