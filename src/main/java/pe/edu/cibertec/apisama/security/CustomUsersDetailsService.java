package pe.edu.cibertec.apisama.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.apisama.model.Roles;
import pe.edu.cibertec.apisama.model.Usuarios;
import pe.edu.cibertec.apisama.repository.IUsuariosRepository;

import java.util.Collection;
import java.util.Collections;

@Service
public class CustomUsersDetailsService implements UserDetailsService  {
    private IUsuariosRepository usuariosRepo;

    @Autowired
    public CustomUsersDetailsService(IUsuariosRepository usuariosRepo) {
        this.usuariosRepo = usuariosRepo;
    }
    //Método para traernos una lista de autoridades por medio de una lista de roles
    public Collection<GrantedAuthority> mapToAuthorities(Roles rol){
        return Collections.singletonList(new SimpleGrantedAuthority(rol.getNombreRol()));
    }
    //Método para traernos un usuario con todos sus datos por medio de sus username
    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuarios usuarios = usuariosRepo.findByCorreo(correo).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return new User(usuarios.getCorreo(), usuarios.getContraseña(), mapToAuthorities(usuarios.getRol()));
    }
}
