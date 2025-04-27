document.getElementById("booking-form").addEventListener("submit", async (e) => {
    e.preventDefault();
    const userId = document.getElementById("userId").value;
    const seat = document.getElementById("seatNumber").value;
  
    const res = await fetch("http://localhost:6010/bookings", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ userId, seatNumber: seat }),
    });
    const data = await res.json();
    document.getElementById("response").innerText = `Booked: ${JSON.stringify(data)}`;
  });
  
  document.getElementById("payment-form").addEventListener("submit", async (e) => {
    e.preventDefault();
    const bookingId = document.getElementById("bookingId").value;
    const amount = document.getElementById("amount").value;
  
    const res = await fetch("http://localhost:6030/payments", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ bookingId, amount }),
    });
    const data = await res.json();
    document.getElementById("response").innerText = `Payment: ${JSON.stringify(data)}`;
  });
  