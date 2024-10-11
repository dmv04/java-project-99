package hexlet.code.component;

import hexlet.code.model.TaskStatus;
import hexlet.code.model.User;
import hexlet.code.repository.TaskStatusRepository;
import hexlet.code.repository.UserRepository;
import hexlet.code.service.CustomUserDetailsService;
import hexlet.code.utils.TaskStatusSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private TaskStatusRepository taskStatusRepository;
    public void run(ApplicationArguments args) {
        var userData = new User();
        userData.setEmail("hexlet@example.com");
        userData.setPasswordDigest("qwerty");
        customUserDetailsService.createUser(userData);

        for (TaskStatusSet status : TaskStatusSet.values()) {
            var taskStatus = new TaskStatus();
            taskStatus.setName(status.getName());
            taskStatus.setSlug(status.getSlug());
            taskStatusRepository.save(taskStatus);
        }
    }
}
