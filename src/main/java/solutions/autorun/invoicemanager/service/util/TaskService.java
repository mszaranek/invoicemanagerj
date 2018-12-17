package solutions.autorun.invoicemanager.service.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import solutions.autorun.academy.model.Task;

import java.util.Set;

public interface TaskService {

    void saveTasks(Set<Task> tasks);

    Page<Task> getTasksForEstimation(Long userId, Pageable pageable);
}
