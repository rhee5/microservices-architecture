.PHONY: start stop

start:
	nohup bash -c "(cd ./start-report && gradle bootRun) &" > start-report.log 2>&1 &
	nohup bash -c "(cd ./process-report && gradle bootRun) &" > process-report.log 2>&1 &
	nohup bash -c "(cd ./holiday-demo && gradle bootRun) &" > holiday-demo.log 2>&1 &

stop:
	powershell -Command "Stop-Process -Id (Get-NetTCPConnection -LocalPort 8080).OwningProcess -Force"
	powershell -Command "Stop-Process -Id (Get-NetTCPConnection -LocalPort 8081).OwningProcess -Force"
	powershell -Command "Stop-Process -Id (Get-NetTCPConnection -LocalPort 8082).OwningProcess -Force"

