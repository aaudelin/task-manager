import Image from "next/image";
import {Button} from "@/components/ui/button";

export default function Home() {
  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-24">
      <Button
        variant="outline"
        size="lg"
        className="flex items-center space-x-2"
      >
          Click me
      </Button>
    </main>
  );
}
