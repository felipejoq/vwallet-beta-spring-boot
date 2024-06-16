package com.uncodigo.vwallet.controllers;

import com.uncodigo.vwallet.models.BankAccount;
import com.uncodigo.vwallet.models.Transactions;
import com.uncodigo.vwallet.services.IBankAccountService;
import com.uncodigo.vwallet.services.ITransactionService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private static final Logger logger = LogManager.getLogger(DashboardController.class);

    private final IBankAccountService bankAccountService;
    private final ITransactionService transactionService;

    public DashboardController(IBankAccountService bankAccountService, ITransactionService transactionService) {
        this.bankAccountService = bankAccountService;
        this.transactionService = transactionService;
    }

    @RequestMapping
    public String dashboard(Model model, HttpServletRequest request) {

        // Obtener de la autenticación el email del usuario
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        // Buscar la cuenta bancaria del usuario
        Optional<BankAccount> bankAccountOptional = bankAccountService.findBankAccountByUserEmail(userEmail);
        Collection<Transactions> transactions = transactionService.getTransactionsByUserEmail(userEmail);

        if (bankAccountOptional.isEmpty()) {
            logger.error("No se encontró la cuenta bancaria del usuario con email: {}", userEmail);
            return "redirect:/";
        }

        if (request.getSession().getAttribute("loginSuccess") != null) {
            model.addAttribute("loginSuccess", request.getSession().getAttribute("loginSuccess"));
            request.getSession().removeAttribute("loginSuccess");
        }

        BankAccount bankAccount = bankAccountOptional.get();

        model.addAttribute("bankAccount", bankAccount);
        model.addAttribute("transactions", transactions);

        return "views/privates/dashboard";
    }
}
