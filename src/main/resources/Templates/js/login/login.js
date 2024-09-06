document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    
    fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            username: username,
            password: password,
        }),
    })
    .then(response => {
        if (!response.ok) {
            return response.text().then(text => {
                throw new Error(`Error ${response.status}: ${text}`);
            });
        }
        return response.json(); 
    })
    .then(data => {
        const token = data.token; 
        localStorage.setItem('jwtToken', token);

        // localStorage.removeItem('jwtToken') <3 vms

        console.log("TOKEN GEN " + token)


        const payloadBase64 = token.split('.')[1];
        const decodedPayload = JSON.parse(atob(payloadBase64));
        const userRole = decodedPayload.role;

        // Redirigir según el rol
        if (userRole.includes('ADMIN')) {
            window.location.href = 'menuAdmin.html'; 
        } else if (userRole.includes('USER')) {
            window.location.href = 'menuUsers.html'; 
        } else {
            alert('Rol de usuario no reconocido.');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al autenticar.');
    });
});