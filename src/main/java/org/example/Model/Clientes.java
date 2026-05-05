package org.example.Model;

public class Clientes {
    private int ClienteID;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Email;
    private String Direccion;

    public Clientes() {}

    public Clientes(int clienteID, String nombre, String apellido,
                    String telefono, String email, String direccion) {
        this.ClienteID = clienteID;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Telefono = telefono;
        this.Email = email;
        this.Direccion = direccion;
    }

    public int getClienteID() { return ClienteID; }
    public void setClienteID(int clienteID) { this.ClienteID = clienteID; }

    public String getNombre() { return Nombre; }
    public void setNombre(String nombre) { this.Nombre = nombre; }

    public String getApellido() { return Apellido; }
    public void setApellido(String apellido) { this.Apellido = apellido; }

    public String getTelefono() { return Telefono; }
    public void setTelefono(String telefono) { this.Telefono = telefono; }

    public String getEmail() { return Email; }
    public void setEmail(String email) { this.Email = email; }

    public String getDireccion() { return Direccion; }
    public void setDireccion(String direccion) { this.Direccion = direccion; }

    @Override
    public String toString() {
        return "Cliente{" +
                "ID=" + ClienteID +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Email='" + Email + '\'' +
                ", Direccion='" + Direccion + '\'' +
                '}';
    }
}