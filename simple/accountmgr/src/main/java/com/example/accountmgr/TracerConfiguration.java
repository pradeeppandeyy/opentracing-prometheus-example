package com.example.accountmgr;

import org.springframework.context.annotation.Bean;
import java.util.regex.Pattern;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TracerConfiguration implements javax.servlet.ServletContextListener {

	@Bean
	public io.opentracing.Tracer tracer() {
		return io.opentracing.contrib.tracerresolver.TracerResolver.resolveTracer();
	}

	@Override
	public void contextInitialized(javax.servlet.ServletContextEvent sce) {
		sce.getServletContext().setAttribute(io.opentracing.contrib.web.servlet.filter.TracingFilter.SKIP_PATTERN, Pattern.compile("/metrics"));
	}

	@Override
	public void contextDestroyed(javax.servlet.ServletContextEvent sce) {
	}

}
