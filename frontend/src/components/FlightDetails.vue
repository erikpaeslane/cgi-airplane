<template>
    <div v-if="flight" class="flight-details">
      <h1>Flight Details</h1>
      <div class="flight-info">
        <p><strong>Departure:</strong> {{ flight.departurePlace }} at {{ flight.departureTime }}</p>
        <p><strong>Arrival:</strong> {{ flight.arrivalPlace }} at {{ flight.arrivalTime }}</p>
        <p><strong>Cost:</strong> ${{ flight.cost }}</p>
      </div>
  
      <div class="seating-chart">
        <h2>{{ flight.arrivalPlace }}</h2>
        <div v-for="(row, indexX) in flight.seats" :key="indexX" class="seat-row">
          <div v-for="(col, indexY) in row" :key="indexY" class="seat">
            <div v-if="indexY === Math.floor(row.length / 2)" class="aisle"></div>
            <button
              :style="{ backgroundColor: flight.seats[indexX][indexY] ? 'red' : 'gray' }"
              :disabled="flight.seats[indexX][indexY]"
            ></button>
          </div>
        </div>
      </div>
    </div>
  </template>
  <script>
  import axios from "axios";
  
  export default {
    name: "FlightDetails",
    data() {
      return {
        flight: null,
      };
    },
    async created() {
      try {
        const response = await axios.get(`http://localhost:8080/api/flights/${this.$route.params.id}`);
        this.flight = response.data;
        console.log(this.flight.seats);
      } catch (error) {
        console.error("Error fetching flight details:", error);
      }
    },
  };
  </script>
  
  <style scoped>
  .flight-details {
    text-align: center;
    padding: 20px;
  }
  
  .flight-info {
    margin-bottom: 20px;
    font-size: 16px;
  }
  
  .seating-chart {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 5px;
  }
  
  .seat-row {
    display: flex;
    gap: 5px;
  }
  
  .seat button {
    width: 30px;
    height: 30px;
    border: none;
    cursor: pointer;
  }
  </style>