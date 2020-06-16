# stop the process running on port 8080
```
#netstat -ano | findstr :PORT_NUMBER
#taskkill /PID PORT_NUMBER /F
netstat -ano | findstr :8080
#taskkill /PID <<PID>> /F
taskkill /F /PID 4496

```