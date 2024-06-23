package DAO.Interfaces;

import Modelo.Trabajadores;

public interface LoginDAO {
    Trabajadores verificarCuenta(String user, String pass);
}
