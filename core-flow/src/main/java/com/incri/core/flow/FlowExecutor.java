package com.incri.core.flow;

import com.incri.core.contract.command.Command;

public class FlowExecutor {

  public <C extends Command, R> R execute(UseCase<C, R> useCase, C command) {
    return useCase.execute(command);
  }
}