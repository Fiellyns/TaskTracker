import ru.yandex.practicum.manager.Manager;
import ru.yandex.practicum.tasks.Task;
import ru.yandex.practicum.tasks.Subtask;
import ru.yandex.practicum.tasks.Epic;
import ru.yandex.practicum.tasks.Status;

    public class Main {
        public static void main(String[] args) {
            Manager manager = new Manager();

            Task task1 = manager.createTask(new Task("Отдых", "поехать на море"));
            Task task2 = manager.createTask(new Task("Дом", "вынести мусор"));

            Epic epic1 = manager.createEpic(new Epic("Дом", "любимый дом"));
            Epic epic2 = manager.createEpic(new Epic("Кот", "любимый кот"));

            Subtask subtask1 = manager.createSubTask(new Subtask("Купить молоко", "3.2%", epic1.getId()));
            Subtask subtask2 = manager.createSubTask(new Subtask("Купить кофе", "черный, молотый", epic1.getId()));
            Subtask subtask3 = manager.createSubTask(new Subtask("Купить корм", "Royal Canin, до 6 месяцев", epic2.getId()));

            // Вывод всего

            System.out.println(manager.getTaskList());
            System.out.println(manager.getEpicList());
            System.out.println(manager.getSubTaskList());


            // Обновления статусов
            System.out.println("Производится обновление статусов...");
            subtask1.setStatus(Status.IN_PROGRESS);
            manager.updateSubtask(subtask1);

            subtask2.setStatus(Status.DONE);
            manager.updateSubtask(subtask2);

            subtask3.setStatus(Status.DONE);
            manager.updateSubtask(subtask3);

            task1.setStatus(Status.IN_PROGRESS);
            manager.updateTask(task1);

            task2.setStatus(Status.DONE);
            manager.updateTask(task2);

            System.out.println("Обновление статусов завершено.");

            // Вывод всего
            System.out.println(manager.getTaskList());
            System.out.println(manager.getEpicList());
            System.out.println(manager.getSubTaskList());

            // Удаление таска
            manager.deleteTaskById(task1.getId());
            System.out.println("Удаление таска");
            // Удаление эпика
            manager.deleteEpicById(epic1.getId());
            System.out.println("Удаление эпика");

            // Вывод всего
            System.out.println(manager.getTaskList());
            System.out.println(manager.getEpicList());
            System.out.println(manager.getSubTaskList());

            // Удаление всех тасков
            manager.deleteTasks();
            // Удаление всех эпиков
            manager.deleteEpics();
            // Удаление всех сабтасков
            manager.deleteSubTasks();
            System.out.println("Все типы задач удалены");

            // Вывод всего
            System.out.println(manager.getTaskList());
            System.out.println(manager.getEpicList());
            System.out.println(manager.getSubTaskList());
        }
    }
