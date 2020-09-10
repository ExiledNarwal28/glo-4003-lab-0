package ca.ulaval.glo4003.ws.api.calllog;

import ca.ulaval.glo4003.ws.api.calllog.dto.CallLogDto;

import java.util.List;

public interface CallLogResource {

  List<CallLogDto> getCallLogs();

  void deleteCallLog(String id);
}
