// Create a new Map to store material emissions
let materialEmissionsMap = new Map();

// Adding sample data (material and its CO2 emission per kg)
materialEmissionsMap.set("Steel", 1900.0);        // 1900 grams of CO2 per kg for Steel
materialEmissionsMap.set("Stainless Steel", 2200.0);  // 2200 grams of CO2 per kg for Stainless Steel
materialEmissionsMap.set("Aluminium", 8700.0);    // 8700 grams of CO2 per kg for Aluminium
materialEmissionsMap.set("Copper", 4000.0);       // 4000 grams of CO2 per kg for Copper
materialEmissionsMap.set("Plastic", 6000.0);      // 6000 grams of CO2 per kg for Plastic
materialEmissionsMap.set("Ceramics", 500.0);      // 500 grams of CO2 per kg for Ceramics
materialEmissionsMap.set("Glass", 500.0);         // 500 grams of CO2 per kg for Glass
materialEmissionsMap.set("Paper", 1200.0);        // 1200 grams of CO2 per kg for Paper

function cal() {
    const num1 = parseFloat(document.getElementById('duration').value);
    const num2 = materialEmissionsMap.get(document.getElementById('materials').value);
    const sum = (num1 * num2)/1000;
	document.getElementById('input3').value=sum;
	   const r=document.getElementById('input3').value;
	   console.log(r);
    document.getElementById('result').innerText = `Result: ${sum}`;
  }