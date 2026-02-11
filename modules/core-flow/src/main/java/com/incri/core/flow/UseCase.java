package com.incri.core.flow;

import com.incri.core.contract.command.Command;

public interface UseCase<C extends Command, R> {
  R execute(C command);
}