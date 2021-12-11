import { configureStore } from '@reduxjs/toolkit';
import sellersReducer from './sellersSlice';
import productsReducer from './productsSlice';
import citiesReducer from './citiesSlice';

export const store = configureStore({
  reducer: {
    sellers: sellersReducer,
    products: productsReducer,
    cities: citiesReducer,
  },
});
