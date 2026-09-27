package com.scc.dao;

import com.scc.model.Expense;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDao {
    private List<Expense> expenseList = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenseList.add(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseList;
    }

    public double getTotalExpenses() {
        double total = 0;
        for (Expense e : expenseList) {
            total += e.getAmount();
        }
        return total;
    }
}