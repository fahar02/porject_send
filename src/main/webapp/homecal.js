

    // Create a new Map to store material emissions
let co2EmissionsMap = new Map();

// Adding some sample data (device and its CO2 emission per hour in grams)
        co2EmissionsMap.set("Heater", 1500.0);  // 1500 grams of CO2 per hour for Heater
        co2EmissionsMap.set("AC", 2000.0);      // 2000 grams of CO2 per hour for AC
        co2EmissionsMap.set("Water", 800.0);    // 800 grams of CO2 per hour for Water Heater
        co2EmissionsMap.set("Light", 30.0);     // 30 grams of CO2 per hour for Light (for energy consumption)
        co2EmissionsMap.set("Other Electronic Device", 100.0);  // 100 grams of CO2 per hour for other electronics

function cal() {
    const num1 = parseFloat(document.getElementById('duration').value);
    const num2 = co2EmissionsMap.get(document.getElementById('homeAppliance').value);
    const sum = (num1 * num2)/1000;
	document.getElementById('input3').value=sum;
	   const r=document.getElementById('input3').value;
	   console.log(r);
    document.getElementById('result').innerText = `Result: ${sum}`;
  }