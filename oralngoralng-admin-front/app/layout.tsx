import '@/styles/globals.css'
import Header from "@/ui/Header";
import React from "react";

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
