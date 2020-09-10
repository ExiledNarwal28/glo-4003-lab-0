package ca.ulaval.glo4003.ws.infrastructure.calllog;

import ca.ulaval.glo4003.ws.domain.calllog.CallLog;
import com.google.common.truth.Truth;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CallLogRepositoryInMemoryTest {

  private static final String CALL_LOG_ID = "id";

  @Mock
  private CallLog callLog;

  private CallLogRepositoryInMemory callLogRepositoryInMemory;

  @Before
  public void setUp() {
    callLogRepositoryInMemory = new CallLogRepositoryInMemory();
    BDDMockito.given(callLog.getId()).willReturn(CALL_LOG_ID);
  }

  @Test
  public void givenCallLog_whenFindAll_thenReturnCallLogInMemory() {
    callLogRepositoryInMemory.save(callLog);

    List<CallLog> callLogs = callLogRepositoryInMemory.findAll();

    Truth.assertThat(callLogs).contains(callLog);
  }

  @Test
  public void givenCallLog_whenRemove_thenRemoveCallLogFromMemory() {
    callLogRepositoryInMemory.save(callLog);
    callLogRepositoryInMemory.remove(callLog.getId());

    List<CallLog> callLogs = callLogRepositoryInMemory.findAll();

    Truth.assertThat(callLogs).doesNotContain(callLog);
  }
}