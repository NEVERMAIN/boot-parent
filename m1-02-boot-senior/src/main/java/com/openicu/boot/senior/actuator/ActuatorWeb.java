package com.openicu.boot.senior.actuator;

import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/9/14
 */
@RestController
public class ActuatorWeb {
/*
Get接口：http://localhost:8080/monitor/health
{
    // 状态值
	"status": "UP",
	"components": {
	    // 磁盘空间
		"diskSpace": {
			"status": "UP",
			"details": {
				"total": 250685575168,
				"free": 112149811200,
				"threshold": 10485760,
				"path": "Path/butte-spring-parent/.",
				"exists": true
			}
		},
		// Ping检查
		"ping": {
			"status": "UP"
		}
	}
}

Get接口：http://localhost:8080/monitor/beans
{
	"contexts": {
		"boot-senior": {
			"beans": {
				"asyncPool": {
					"scope": "singleton",
					"type": "org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor",
					"resource": "class path resource [com/boot/senior/schedule/PoolConfig.class]"
				},
				"asyncService": {
					"scope": "singleton",
					"type": "com.boot.senior.schedule.AsyncService$$SpringCGLIB$$0"
				}
			}
		}
	}
}

Post接口：http://localhost:8080/monitor/shutdown
{
    "message": "Shutting down, bye..."
}

 */
}
