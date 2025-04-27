// Booking form submission
document.getElementById("booking-form").addEventListener("submit", async (e) => {
  e.preventDefault();
  
  // Gather form data
  const userId = document.getElementById("userId").value;
  const seat = document.getElementById("seatNumber").value;
  const movie = document.getElementById("movie").value;
  const userEmail = document.getElementById("userEmail").value;

  // Send the data to the Booking API
  const res = await fetch("http://127.0.0.1:6010/bookings", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ 
          userId, 
          movie, 
          seat, 
          userEmail 
      }),
  });

  // Process the response
  const data = await res.json();
  if (res.ok) {
      // Booking was successful, extract booking ID from the response
      const bookingId = data.bookingId;

      // Display booking ID in a new row in the response section
      const bookingRow = document.createElement("div");
      bookingRow.classList.add("booking-row");
      bookingRow.innerHTML = `Booking requested with ID: <strong>${bookingId}</strong>`;

      // Append the row to the response container
      document.getElementById("response").appendChild(bookingRow);
      
      // Autofill the payment form with the booking ID
      document.getElementById("bookingId").value = bookingId;
  } else {
      // If there is an error, display the error message from the response
      document.getElementById("response").innerText = `Booking failed: ${data.message || 'Unknown error'}`;
  }
});


// Payment form submission
document.getElementById("payment-form").addEventListener("submit", async (e) => {
  e.preventDefault();
  
  // Gather form data
  const bookingId = document.getElementById("bookingId").value;
  const amount = document.getElementById("amount").value;

  // Send the data to the Payment API
  const res = await fetch("http://localhost:6030/payment/process", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ 
          bookingId, 
          amount 
      }),
  });

  // Process the response
  const data = await res.json();
  if (res.ok) {
      // Display success message
      document.getElementById("response").innerText = `Payment processed successfully for booking ID: ${bookingId}`;
  } else {
      // If there is an error, display the error message from the response
      document.getElementById("response").innerText = `Payment failed: ${data.message || 'Unknown error'}`;
  }
});
