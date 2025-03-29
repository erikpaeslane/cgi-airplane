<template>
    <div class="flight-list">
      <header>
        <h1>Flight List</h1>
        <p>Select your next flight!</p>
      </header>
  
      <div class="flights">
        <div v-for="(flight, index) in flights" :key="index" class="flight-card">
          <h2>{{ flight.name }}</h2>
          <p><strong>Departure:</strong> {{ formatDate(flight.departureTime) }}</p>
          <p><strong>Arrival:</strong> {{ formatDate(flight.arrivalTime) }}</p>
          <p><strong>From:</strong> {{ flight.departurePlace }}</p>
          <p><strong>To:</strong> {{ flight.arrivalPlace }}</p>
          <router-link :to="'/flights/' + flight.id">
              <button class="select-btn">Broneeri kohad</button>
            </router-link>
        </div>
      </div>
    </div>
  </template>
  
  <script>
    import axios from 'axios';

  export default {
    name: 'FlightList',
    data() {
      return {
        flights: [],
      };
    },
    async created() {
        const response = await axios.get('http://localhost:8080/api/flights');
        this.flights = response.data;
    },
    methods: {
        formatDate(date) {
      const options = {
        day: "2-digit",
        month: "2-digit",
        year: "2-digit",
        hour: "2-digit",
        minute: "2-digit",
      };
      const jsDate = new Date(date);
      return jsDate.toLocaleString("en-GB", options); // en-GB gives dd-MM-yy HH:mm format
    },
    },
  };
  </script>
  
  <style scoped>
  .flight-list {
    font-family: Arial, sans-serif;
    text-align: center;
    padding: 20px;
  }
  
  header {
    background-color: #007bff;
    color: white;
    padding: 10px 0;
    margin-bottom: 20px;
  }
  
  h1 {
    font-size: 2.5rem;
    margin-bottom: 10px;
  }
  
  p {
    font-size: 1.2rem;
    margin-bottom: 20px;
  }
  
  .flights {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
    gap: 20px;
  }
  
  .flight-card {
    background: #f8f9fa;
    border-radius: 8px;
    padding: 20px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    text-align: left;
  }
  
  .flight-card h2 {
    font-size: 1.8rem;
    color: #333;
  }
  
  .flight-card p {
    font-size: 1rem;
    margin: 5px 0;
  }
  
  .select-btn {
    background-color: #007bff;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 1rem;
  }
  
  .select-btn:hover {
    background-color: #0056b3;
  }
  </style>