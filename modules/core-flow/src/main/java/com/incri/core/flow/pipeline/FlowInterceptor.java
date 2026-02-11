package com.incri.core.flow.pipeline;

import com.incri.core.contract.command.Command;

public interface FlowInterceptor<C extends Command, R> {

  R around(Chain<C, R> chain, C command);

  interface Chain<C extends Command, R> {
    R proceed(C command);
  }
}