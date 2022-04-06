package com.br.itau.cat.collector.application.listener;

import com.br.itau.cat.collector.application.service.CollectCatInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;

@Slf4j
public class TaskListener implements TaskExecutionListener {

  @Autowired
  private CollectCatInfoService collectCatInfoService;

  @Override
  public void onTaskStartup(final TaskExecution taskExecution) {
    log.info("TaskListener start");
    collectCatInfoService.execute();
  }

  @Override
  public void onTaskEnd(final TaskExecution taskExecution) {
    log.info("TaskListener end successfully");
  }

  @Override
  public void onTaskFailed(final TaskExecution taskExecution, Throwable throwable) {
    log.error("TaskListener was failed: {}", throwable);
  }
}
