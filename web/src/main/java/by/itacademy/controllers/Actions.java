package by.itacademy.controllers;

public enum Actions {

    LEASE {
        {
            this.command = new Lease();
        }
    };

    public ICommand command;
}
