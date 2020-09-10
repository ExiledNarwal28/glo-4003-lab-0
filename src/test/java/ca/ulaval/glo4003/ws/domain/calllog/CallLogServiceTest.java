package ca.ulaval.glo4003.ws.domain.calllog;

import ca.ulaval.glo4003.ws.api.calllog.dto.CallLogDto;
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
public class CallLogServiceTest {

  private static final String CALL_LOG_ID = "id";

  @Mock
  private CallLog callLog;
  @Mock
  private CallLogDto callLogDto;
  @Mock
  private CallLogRepository callLogRepository;
  @Mock
  private CallLogAssembler callLogAssembler;

  private CallLogService callLogService;

  @Before
  public void setUp() {
    callLogService = new CallLogService(callLogRepository, callLogAssembler);
  }

  @Test
  public void givenCallLogsInRepository_whenFindAllCallLogs_thenReturnThose() {
    BDDMockito.given(callLogRepository.findAll()).willReturn(Lists.newArrayList(callLog));
    BDDMockito.given(callLogAssembler.create(callLog)).willReturn(callLogDto);

    List<CallLogDto> callLogDtos = callLogService.findAllCallLogs();

    Truth.assertThat(callLogDtos).contains(callLogDto);
    Mockito.verify(callLogRepository).findAll();
    Mockito.verify(callLogAssembler).create(eq(callLog));
  }

  @Test
  public void whenRemoveCallLog_thenRemoveThem() {
    callLogService.deleteCallLog(CALL_LOG_ID);

    Mockito.verify(callLogRepository).remove(eq(CALL_LOG_ID));
  }
}