package ca.ulaval.glo4003.ws.infrastructure.calllog;

import ca.ulaval.glo4003.ws.domain.calllog.CallLog;
import jersey.repackaged.com.google.common.collect.Lists;

import java.util.List;

public class CallLogDevDataFactory {

  public List<CallLog> createMockData() {
    List<CallLog> callLogs = Lists.newArrayList();

    CallLog callLog1 = new CallLog("514-999-0000", "2016-07-31T16:45:00Z", 65);
    callLog1.setId("1");
    callLogs.add(callLog1);

    CallLog callLog2 = new CallLog("418-682-3092", "2016-06-31T15:29:00Z", 99);
    callLog2.setId("2");
    callLogs.add(callLog2);

    CallLog callLog3 = new CallLog("581-671-0992", "2016-07-30T08:32:33Z", 22);
    callLog3.setId("3");
    callLogs.add(callLog3);

    return callLogs;
  }
}
