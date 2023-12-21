const BASE_URL = "http://localhost:8080/api/calculation";

function postRequest(url, body) {
  const formData = new URLSearchParams();
  for (const key in body) {
    formData.append(key, body[key]);
  }

  return fetch(url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    body: formData
  }).then(response => response.json());
}

export function whatIsThePercentageOf(value1, value2) {
  return postRequest(`${BASE_URL}/what-is-the-percentage-of`, { value1, value2 });
}

export function valueIsWhatPercentageOf(value1, value2) {
  return postRequest(`${BASE_URL}/value-is-what-percentage-of`, { value1, value2 });
}

export function percentageIncrease(oldValue, newValue) {
  return postRequest(`${BASE_URL}/percentage-increase`, { oldValue, newValue });
}

export function percentageDecrease(oldValue, newValue) {
  return postRequest(`${BASE_URL}/percentage-decrease`, { oldValue, newValue });
}

export function increaseByPercentage(value, percentage) {
  return postRequest(`${BASE_URL}/increase-by-percentage`, { value, percentage });
}

export function decreaseByPercentage(value, percentage) {
  return postRequest(`${BASE_URL}/decrease-by-percentage`, { value, percentage });
}

export function initialIncreasedByPercentage(finalValue, percentage) {
  return postRequest(`${BASE_URL}/initial-value-increased-by`, { finalValue, percentage });
}

export function initialDecreasedByPercentage(finalValue, percentage) {
  return postRequest(`${BASE_URL}/initial-value-decreased-by`, { finalValue, percentage });
}