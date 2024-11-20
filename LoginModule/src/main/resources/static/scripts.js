// Scroll event for updating active nav links
document.getElementById('nav-home').classList.add('active');

const navLinks = document.querySelectorAll('nav a');
const sections = document.querySelectorAll('section');

window.addEventListener('scroll', () => {
    let currentSection = "";

    sections.forEach(section => {
        const sectionTop = section.offsetTop - 100;
        if (window.pageYOffset >= sectionTop) {
            currentSection = section.getAttribute('id');
        }
    });

    navLinks.forEach(link => {
        link.classList.remove('active');
        if (link.getAttribute('href') === `#${currentSection}`) {
            link.classList.add('active');
        }
    });
});

// Handle Newsletter Form Submission
document.getElementById('newsletter-form').addEventListener('submit', async (e) => {
    e.preventDefault();
    const email = document.getElementById('newsletter-email').value;
    if (email) {
        alert(`Subscribed successfully with email: ${email}`);
        document.getElementById('newsletter-email').value = '';
    }
});

// Handle Contact Us Form Submission
document.getElementById('contact-form').addEventListener('submit', async (e) => {
    e.preventDefault();
    const name = document.getElementById('contact-name').value;
    const email = document.getElementById('contact-email').value;
    const message = document.getElementById('contact-message').value;

    if (name && email && message) {
        const formData = {
            name: name,
            email: email,
            message: message,
        };

        try {
            // Send POST request to the contact API
            const response = await fetch('http://localhost:8080/api/contact', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData),
            });

            if (response.ok) {
                const result = await response.json(); // If server responds with JSON
                alert(`Message sent successfully! Response: ${result.message || 'Thank you for reaching out.'}`);
                document.getElementById('contact-form').reset();
            } else {
                alert('Failed to send the message. Please try again.');
            }
        } catch (error) {
            console.error('Error:', error);
            alert('An error occurred while sending your message.');
        }
    } else {
        alert('Please fill in all fields before submitting.');
    }
});
