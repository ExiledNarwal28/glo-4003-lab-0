package ca.ulaval.glo4003.ws.api.calllog;

import ca.ulaval.glo4003.ws.api.calllog.dto.CallLogDto;
import ca.ulaval.glo4003.ws.domain.calllog.CallLogService;
import com.google.common.truth.Truth;
import jersey.repackaged.com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Matchers.eq;


@RunWith(MockitoJUnitRunner.class)
public class CallLogResourceImplTest {

  private static final String CALL_LOG_ID = "id";

  @Mock
  private CallLogService callLogService;
  @Mock
  private CallLogDto callLogDto;

  private CallLogResource callLogResource;

  @Before
  public void setUp() {
    callLogResource = new CallLogResourceImpl(callLogService);
  }

  @Test
  public void whenFindAllCallLogs_thenFoundCallLogsFromService() {
    BDDMockito.given(callLogService.findAllCallLogs()).willReturn(Lists.newArrayList(callLogDto));

    List<CallLogDto> callLogDtos = callLogResource.getCallLogs();

    Truth.assertThat(callLogDtos).contains(callLogDto);
  }

  @Test
  public void whenDeleteCallLog_thenDeleteCallLogFromService() {
    callLogResource.deleteCallLog(CALL_LOG_ID);

    Mockito.verify(callLogService).deleteCallLog(eq(CALL_LOG_ID));
  }
}