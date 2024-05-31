package com.mycompany.financemanage.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class GraphicsController {

    @RequestMapping("/graphics")
    public String getExpenseData(Model model) {
        // Здесь вы можете получить данные о расходах из базы данных или другого источника данных
        Map<String, Double> expenseByDate = getExpenseData(); // Метод getExpenseData() должен быть реализован в соответствии с вашей логикой

        // Передаем данные о расходах в модель представления
        model.addAttribute("expenseData", expenseByDate);

        return "graphics"; // Возвращает имя представления (шаблона Thymeleaf) для отображения графика
    }

    private Map<String, Double> getExpenseData() {
        // Пример реализации метода getExpenseData()
        // Здесь вы можете выполнить логику для получения данных о расходах из базы данных или другого источника данных

        // Возвращаем фиктивные данные для примера
        Map<String, Double> expenseByDate = new HashMap<>();
        expenseByDate.put("2023-05-01", 100.0);
        expenseByDate.put("2023-05-02", 150.0);
        expenseByDate.put("2023-05-03", 80.0);
        // и т.д.

        return expenseByDate;
    }
}
