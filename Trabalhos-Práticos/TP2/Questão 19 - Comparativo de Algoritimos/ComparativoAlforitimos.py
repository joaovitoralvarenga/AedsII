import random
import time
import signal
import matplotlib.pyplot as plt
import numpy as np
from typing import List, Tuple, Dict

# Classe para tratar timeout
class TimeoutException(Exception):
    pass

def timeout_handler(signum, frame):
    raise TimeoutException("Tempo limite excedido")

class MetricasOrdenacao:
    def __init__(self):
        self.comparacoes = 0
        self.movimentacoes = 0
        self.tempo = 0
        self.timeout = False

    def reset(self):
        self.comparacoes = 0
        self.movimentacoes = 0
        self.tempo = 0
        self.timeout = False


def SelectionSort(array: List[int], metricas: MetricasOrdenacao, timeout_sec=5) -> List[int]:
    n = len(array)
    resultado = array.copy()

    # Configurar timeout
    signal.signal(signal.SIGALRM, timeout_handler)
    signal.alarm(timeout_sec)
    
    try:
        inicio_tempo = time.time()

        for i in range(n - 1):
            menor = i
            for j in range(i + 1, n):
                metricas.comparacoes += 1
                if resultado[j] < resultado[menor]:
                    menor = j

            if menor != i:
                resultado[i], resultado[menor] = resultado[menor], resultado[i]
                metricas.movimentacoes += 1

        metricas.tempo = (time.time() - inicio_tempo) * 1000

    except TimeoutException:
        metricas.tempo = timeout_sec * 1000
        metricas.timeout = True
        # Estimar valores baseados no progresso até o timeout
        if metricas.comparacoes > 0:
            fator_estimado = n * n / metricas.comparacoes
            metricas.comparacoes = int(n * n / 2)  # Valor teórico O(n²)
            metricas.movimentacoes = int(n / 2)    # Valor teórico O(n)
    
    finally:
        signal.alarm(0)  # Desativar o alarme
    
    return resultado


def InsertionSort(array: List[int], metricas: MetricasOrdenacao, timeout_sec=5) -> List[int]:
    n = len(array)
    resultado = array.copy()
    
    # Configurar timeout
    signal.signal(signal.SIGALRM, timeout_handler)
    signal.alarm(timeout_sec)
    
    try:
        tempo_inicio = time.time()
        
        for i in range(1, n):
            key = resultado[i]
            j = i - 1
            
            while j >= 0:
                metricas.comparacoes += 1
                if resultado[j] > key:
                    resultado[j + 1] = resultado[j]
                    metricas.movimentacoes += 1
                    j -= 1
                else:
                    break
            
            if j + 1 != i:
                resultado[j + 1] = key
                metricas.movimentacoes += 1
        
        metricas.tempo = (time.time() - tempo_inicio) * 1000
    
    except TimeoutException:
        metricas.tempo = timeout_sec * 1000
        metricas.timeout = True
        # Estimar valores baseados no progresso até o timeout
        if metricas.comparacoes > 0:
            metricas.comparacoes = int(n * n / 4)  # Valor teórico O(n²)
            metricas.movimentacoes = int(n * n / 4) # Valor teórico O(n²)
    
    finally:
        signal.alarm(0)  # Desativar o alarme
    
    return resultado


def BubbleSort(array: List[int], metricas: MetricasOrdenacao, timeout_sec=5) -> List[int]:
    n = len(array)
    resultado = array.copy()

    # Configurar timeout
    signal.signal(signal.SIGALRM, timeout_handler)
    signal.alarm(timeout_sec)
    
    try:
        tempo_inicio = time.time()
        
        for i in range(n):
            trocado = False
            
            for j in range(0, n - i - 1):
                metricas.comparacoes += 1
                if resultado[j] > resultado[j + 1]:
                    resultado[j], resultado[j + 1] = resultado[j + 1], resultado[j]
                    metricas.movimentacoes += 1
                    trocado = True
            
            if not trocado:
                break
        
        metricas.tempo = (time.time() - tempo_inicio) * 1000
    
    except TimeoutException:
        metricas.tempo = timeout_sec * 1000
        metricas.timeout = True
        # Estimar valores baseados no progresso até o timeout
        if metricas.comparacoes > 0:
            metricas.comparacoes = int(n * n / 2)  # Valor teórico O(n²)
            metricas.movimentacoes = int(n * n / 2) # Valor teórico O(n²)
    
    finally:
        signal.alarm(0)  # Desativar o alarme
    
    return resultado


def quicksort(arr: List[int], metricas: MetricasOrdenacao, timeout_sec=5) -> List[int]:
    resultado = arr.copy()
    n = len(arr)
    
    # Configurar timeout
    signal.signal(signal.SIGALRM, timeout_handler)
    signal.alarm(timeout_sec)
    
    try:
        tempo_inicio = time.time()
        _quicksort(resultado, 0, len(resultado) - 1, metricas)
        metricas.tempo = (time.time() - tempo_inicio) * 1000
    
    except TimeoutException:
        metricas.tempo = timeout_sec * 1000
        metricas.timeout = True
        # Estimar valores baseados no progresso até o timeout
        if metricas.comparacoes > 0:
            metricas.comparacoes = int(n * np.log2(n))  # Valor teórico O(n log n)
            metricas.movimentacoes = int(n * np.log2(n)) # Valor teórico O(n log n)
    
    finally:
        signal.alarm(0)  # Desativar o alarme
    
    return resultado


def _quicksort(arr: List[int], low: int, high: int, metricas: MetricasOrdenacao):
    if low < high:
        pivo = _partition(arr, low, high, metricas)
        _quicksort(arr, low, pivo - 1, metricas)
        _quicksort(arr, pivo + 1, high, metricas)


def _partition(arr: List[int], low: int, high: int, metricas: MetricasOrdenacao) -> int:
    pivo = arr[high]
    i = low - 1
    
    for j in range(low, high):
        metricas.comparacoes += 1
        if arr[j] <= pivo:
            i += 1
            if i != j:
                arr[i], arr[j] = arr[j], arr[i]
                metricas.movimentacoes += 1
    
    if i + 1 != high:
        arr[i + 1], arr[high] = arr[high], arr[i + 1]
        metricas.movimentacoes += 1
    
    return i + 1


def geraArraysAleatorios(size: int) -> List[int]:
    return [random.randint(0, 100000) for _ in range(size)]


def iniciaAlgoritimos(arr: List[int], timeout_sec=5) -> Dict[str, Dict[str, float]]:
    resultados = {}
    metricas = MetricasOrdenacao()
    n = len(arr)
    
    # Selection Sort
    metricas.reset()
    SelectionSort(arr, metricas, timeout_sec)
    resultados["Selection Sort"] = {
        "time": metricas.tempo,
        "comparisons": metricas.comparacoes,
        "movements": metricas.movimentacoes,
        "timeout": metricas.timeout
    }
    
    # Insertion Sort
    metricas.reset()
    InsertionSort(arr, metricas, timeout_sec)
    resultados["Insertion Sort"] = {
        "time": metricas.tempo,
        "comparisons": metricas.comparacoes,
        "movements": metricas.movimentacoes,
        "timeout": metricas.timeout
    }
    
    # Bubble Sort
    metricas.reset()
    BubbleSort(arr, metricas, timeout_sec)
    resultados["Bubble Sort"] = {
        "time": metricas.tempo,
        "comparisons": metricas.comparacoes,
        "movements": metricas.movimentacoes,
        "timeout": metricas.timeout
    }
    
    # Quicksort
    metricas.reset()
    quicksort(arr, metricas, timeout_sec)
    resultados["Quicksort"] = {
        "time": metricas.tempo,
        "comparisons": metricas.comparacoes,
        "movements": metricas.movimentacoes,
        "timeout": metricas.timeout
    }
    
    return resultados


def create_plots(all_results: Dict[int, Dict[str, Dict[str, float]]]):
    sizes = list(all_results.keys())
    algorithms = ["Selection Sort", "Insertion Sort", "Bubble Sort", "Quicksort"]
    
    # Definir ticks do eixo X de 2000 em 2000
    x_ticks = list(range(0, max(sizes) + 2000, 2000))
    x_ticks = [tick for tick in x_ticks if tick > 0]  # Remove o zero se estiver presente
    
    # Gráfico de tempo de execução
    plt.figure(figsize=(12, 8))
    for algo in algorithms:
        times = [all_results[size][algo]["time"] for size in sizes]
        plt.plot(sizes, times, marker='o', linewidth=2, label=algo)
    
    plt.xscale('log')
    plt.yscale('log')
    plt.title('Tempo de Execução vs. Tamanho do Vetor')
    plt.xlabel('Tamanho do Vetor')
    plt.ylabel('Tempo (ms)')
    plt.grid(True, alpha=0.3)
    plt.legend()
    
    # Criar visualização padrão
    plt.savefig("execution_time_log.png", dpi=300, bbox_inches='tight')
    
    # Versão com escala linear e ticks personalizados de 2000 em 2000
    plt.figure(figsize=(12, 8))
    for algo in algorithms:
        times = [all_results[size][algo]["time"] for size in sizes]
        plt.plot(sizes, times, marker='o', linewidth=2, label=algo)
    
    plt.title('Tempo de Execução vs. Tamanho do Vetor')
    plt.xlabel('Tamanho do Vetor')
    plt.ylabel('Tempo (ms)')
    plt.grid(True, alpha=0.3)
    plt.legend()
    plt.xticks(x_ticks)  # Define os ticks de 2000 em 2000
    
    plt.savefig("execution_time.png", dpi=300, bbox_inches='tight')
    
    # Gráfico de número de comparações
    plt.figure(figsize=(12, 8))
    for algo in algorithms:
        comparisons = [all_results[size][algo]["comparisons"] for size in sizes]
        plt.plot(sizes, comparisons, marker='o', linewidth=2, label=algo)
    
    plt.xscale('log')
    plt.yscale('log')
    plt.title('Número de Comparações vs. Tamanho do Vetor')
    plt.xlabel('Tamanho do Vetor')
    plt.ylabel('Número de Comparações')
    plt.grid(True, alpha=0.3)
    plt.legend()
    
    # Salvar versão logarítmica
    plt.savefig("comparisons_log.png", dpi=300, bbox_inches='tight')
    
    # Versão com escala linear e ticks personalizados de 2000 em 2000
    plt.figure(figsize=(12, 8))
    for algo in algorithms:
        comparisons = [all_results[size][algo]["comparisons"] for size in sizes]
        plt.plot(sizes, comparisons, marker='o', linewidth=2, label=algo)
    
    plt.title('Número de Comparações vs. Tamanho do Vetor')
    plt.xlabel('Tamanho do Vetor')
    plt.ylabel('Número de Comparações')
    plt.grid(True, alpha=0.3)
    plt.legend()
    plt.xticks(x_ticks)  # Define os ticks de 2000 em 2000
    
    plt.savefig("comparisons.png", dpi=300, bbox_inches='tight')
    
    # Gráfico de número de movimentações
    plt.figure(figsize=(12, 8))
    for algo in algorithms:
        movements = [all_results[size][algo]["movements"] for size in sizes]
        plt.plot(sizes, movements, marker='o', linewidth=2, label=algo)
    
    plt.xscale('log')
    plt.yscale('log')
    plt.title('Número de Movimentações vs. Tamanho do Vetor')
    plt.xlabel('Tamanho do Vetor')
    plt.ylabel('Número de Movimentações')
    plt.grid(True, alpha=0.3)
    plt.legend()
    
    # Salvar versão logarítmica
    plt.savefig("movements_log.png", dpi=300, bbox_inches='tight')
    
    # Versão com escala linear e ticks personalizados de 2000 em 2000
    plt.figure(figsize=(12, 8))
    for algo in algorithms:
        movements = [all_results[size][algo]["movements"] for size in sizes]
        plt.plot(sizes, movements, marker='o', linewidth=2, label=algo)
    
    plt.title('Número de Movimentações vs. Tamanho do Vetor')
    plt.xlabel('Tamanho do Vetor')
    plt.ylabel('Número de Movimentações')
    plt.grid(True, alpha=0.3)
    plt.legend()
    plt.xticks(x_ticks)  # Define os ticks de 2000 em 2000
    
    plt.savefig("movements.png", dpi=300, bbox_inches='tight')
    
    # Adicionar um gráfico combinado que evidencia as diferenças para o maior tamanho
    max_size = max(sizes)
    
    plt.figure(figsize=(15, 5))
    plt.subplot(131)
    
    # Tempos para o maior tamanho
    algoritmos = []
    tempos = []
    for algo in algorithms:
        algoritmos.append(algo)
        tempos.append(all_results[max_size][algo]["time"])
    
    plt.bar(algoritmos, tempos)
    plt.title(f'Tempo (ms) para n={max_size}')
    plt.yscale('log')
    plt.xticks(rotation=45, ha='right')
    
    plt.subplot(132)
    # Comparações para o maior tamanho
    comparacoes = []
    for algo in algorithms:
        comparacoes.append(all_results[max_size][algo]["comparisons"])
    
    plt.bar(algoritmos, comparacoes)
    plt.title(f'Comparações para n={max_size}')
    plt.yscale('log')
    plt.xticks(rotation=45, ha='right')
    
    plt.subplot(133)
    # Movimentações para o maior tamanho
    movimentacoes = []
    for algo in algorithms:
        movimentacoes.append(all_results[max_size][algo]["movements"])
    
    plt.bar(algoritmos, movimentacoes)
    plt.title(f'Movimentações para n={max_size}')
    plt.yscale('log')
    plt.xticks(rotation=45, ha='right')
    
    plt.tight_layout()
    plt.savefig("comparison_maior_tamanho.png", dpi=300, bbox_inches='tight')
def main():
    # Tamanhos dos vetores - reduzindo o maior tamanho para 50.000
    sizes = [100, 1000, 5000, 10000]
    
    # Dicionário para armazenar todos os resultados
    all_results = {}
    
    # Definir timeout em segundos para cada tamanho
    timeouts = {
        100: 1,        # 1 segundo para n=100
        1000: 2,       # 2 segundos para n=1000
        5000: 5,       # 5 segundos para n=5000
        10000: 10      # 10 segundos para n=10000
    }
    
    # Executar algoritmos para cada tamanho
    for size in sizes:
        print(f"\nExecutando algoritmos para vetor de tamanho {size}...")
        random_array = geraArraysAleatorios(size)
        all_results[size] = iniciaAlgoritimos(random_array, timeout_sec=timeouts[size])
        
        # Exibir resultados para o tamanho atual
        print(f"Resultados para vetor de tamanho {size}:")
        for algo, metrics in all_results[size].items():
            status = "(TIMEOUT)" if metrics.get("timeout", False) else ""
            print(f"  {algo}: {status}")
            print(f"    Tempo de execução: {metrics['time']:.2f} ms")
            print(f"    Comparações: {metrics['comparisons']}")
            print(f"    Movimentações: {metrics['movements']}")
    
    # Criar gráficos
    create_plots(all_results)
    print("\nGráficos criados com sucesso!")
    
    # Exibir tabela comparativa para o relatório
    print("\nTabela Comparativa:")
    print("Algoritmo       | Tamanho | Tempo (ms) | Comparações | Movimentações | Status")
    print("-" * 80)
    
    for size in sizes:
        for algo in ["Selection Sort", "Insertion Sort", "Bubble Sort", "Quicksort"]:
            metrics = all_results[size][algo]
            status = "TIMEOUT" if metrics.get("timeout", False) else "OK"
            print(f"{algo:15} | {size:7} | {metrics['time']:9.2f} | {metrics['comparisons']:10} | {metrics['movements']:12} | {status}")


if __name__ == "__main__":
    main()