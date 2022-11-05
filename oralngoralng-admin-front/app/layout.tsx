import '@/styles/globals.css'
import Header from "@/ui/Header";

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html>
      <head><title>OralngOralng</title></head>
      <body>
      <Header/>
      {children}
      </body>
    </html>
  )
}
