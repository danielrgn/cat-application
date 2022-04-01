package com.br.itau.catapplication.listener;

import com.br.itau.catapplication.service.CollectCatInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;

public class TaskListener implements TaskExecutionListener {

  @Autowired
  private CollectCatInfoService collectCatInfoService;

  @Override
  public void onTaskStartup(TaskExecution taskExecution) {
    collectCatInfoService.execute();
  }

  @Override
  public void onTaskEnd(TaskExecution taskExecution) {
    // Do nothing.
  }

  @Override
  public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {
    // Do nothing.
  }
}
