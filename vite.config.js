import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    host: '0.0.0.0',        // Bind to all network interfaces
    port: process.env.PORT || 5173,  // Use the PORT environment variable provided by Render, fallback to 5173 for local development
  },
})
